// Stefan Nilsson 2013-02-27

// This program creates pictures of Julia sets (en.wikipedia.org/wiki/Julia_set).
package main

import (
	"fmt"
	"image"
	"image/color"
	"image/png"
	"log"
	"math/cmplx"
	"os"
	"runtime"
	"strconv"
	"sync"
	"time"
)

type ComplexFunc func(complex128) complex128

var Funcs []ComplexFunc = []ComplexFunc{
	func(z complex128) complex128 { return z*z - 0.61803398875 },
	func(z complex128) complex128 { return z*z + complex(0, 1) },
	func(z complex128) complex128 { return z*z + complex(-0.835, -0.2321) },
	func(z complex128) complex128 { return z*z + complex(0.45, 0.1428) },
	func(z complex128) complex128 { return z*z*z + 0.400 },
	func(z complex128) complex128 { return cmplx.Exp(z*z*z) - 0.621 },
	func(z complex128) complex128 { return (z*z+z)/cmplx.Log(z) + complex(0.268, 0.060) },
	func(z complex128) complex128 { return cmplx.Sqrt(cmplx.Sinh(z*z)) + complex(0.065, 0.122) },
}

func main() {
	// use all the power!
	numcpu := runtime.NumCPU()
	runtime.GOMAXPROCS(numcpu)

	start := time.Now()

	ch := make(chan error, len(Funcs)) // new channel

	wg := new(sync.WaitGroup)
	wg.Add(len(Funcs)) // the number of functions = no. of pictures.
	for n, fn := range Funcs {
		go CreatePng("picture-"+strconv.Itoa(n)+".png", fn, 1024, wg, ch)
	}

	wg.Wait()
	close(ch)

	for k := range ch {
		if k != nil {
			log.Fatal(k)
		}
	}
	fmt.Println(time.Since(start))
}

// CreatePng creates a PNG picture file with a Julia image of size n x n.
func CreatePng(filename string, f ComplexFunc, n int, wg *sync.WaitGroup, ch chan error) { // need pointer to wg.
	file, err := os.Create(filename)
	if err != nil {
		ch <- err
		return
	}
	defer file.Close()
	ch <- png.Encode(file, Julia(f, n))

	wg.Done()
	return
}

// Julia returns an image of size n x n of the Julia set for f.
func Julia(f ComplexFunc, n int) image.Image {
	bounds := image.Rect(-n/2, -n/2, n/2, n/2)
	img := image.NewRGBA(bounds)
	s := float64(n / 4)

	// code duplication... not good.

	for i := bounds.Min.X; i < bounds.Max.X; i++ {
		wg := new(sync.WaitGroup)
		wg.Add(4)
		go func() {
			for j := bounds.Min.Y; j < bounds.Max.Y/4; j++ {

				n := Iterate(f, complex(float64(i)/s, float64(j)/s), 256)
				r := uint8(0)
				g := uint8(0)
				b := uint8(n % 32 * 8)
				img.Set(i, j, color.RGBA{r, g, b, 255})

			}

			wg.Done()
		}()

		go func() {
			for j := bounds.Max.Y / 4; j < 2*(bounds.Max.Y/4); j++ {

				n := Iterate(f, complex(float64(i)/s, float64(j)/s), 256)
				r := uint8(0)
				g := uint8(0)
				b := uint8(n % 32 * 8)
				img.Set(i, j, color.RGBA{r, g, b, 255})

			}
			wg.Done()
		}()

		go func() {
			for j := 2 * (bounds.Max.Y / 4); j < 3*(bounds.Max.Y/4); j++ {

				n := Iterate(f, complex(float64(i)/s, float64(j)/s), 256)
				r := uint8(0)
				g := uint8(0)
				b := uint8(n % 32 * 8)
				img.Set(i, j, color.RGBA{r, g, b, 255})

			}
			wg.Done()
		}()

		go func() {
			for j := 3*(bounds.Max.Y/4) + (bounds.Max.Y % 4); j < bounds.Max.Y; j++ {

				n := Iterate(f, complex(float64(i)/s, float64(j)/s), 256)
				r := uint8(0)
				g := uint8(0)
				b := uint8(n % 32 * 8)
				img.Set(i, j, color.RGBA{r, g, b, 255})

			}
			wg.Done()
		}()

		wg.Wait()
	}

	return img
}

// Iterate sets z_0 = z, and repeatedly computes z_n = f(z_{n-1}), n 1,
// until |z_n| > 2  or n = max and returns this n.
func Iterate(f ComplexFunc, z complex128, max int) (n int) {
	for ; n < max; n++ {
		if real(z)*real(z)+imag(z)*imag(z) > 4 {
			break
		}
		z = f(z)
	}
	return
}
