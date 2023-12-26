function distributeGifts(weights) {

    const result = new Array(weights.length)
        .fill(0)
        .map(() => new Array(weights[0].length).fill(0))

    for (let row = 0; row < weights.length; row++) {

        for (let col = 0; col < weights[row].length; col++) {

            const neighbors = []
            neighbors.push(weights[row][col])

            if (weights[row - 1] && weights[row - 1][col]) {
                neighbors.push(weights[row - 1][col])
            }

            if (weights[row][col - 1]) {
                neighbors.push(weights[row][col - 1])
            }

            if (weights[row][col + 1]) {
                neighbors.push(weights[row][col + 1])
            }

            if (weights[row + 1] && weights[row + 1][col]) {
                neighbors.push(weights[row + 1][col])
            }

            result[row][col] = Math.round(
                neighbors.reduce((acc, curr) => acc + curr)
                /
                neighbors.filter(x => x != null).length);
        }

    }

    return result
}

const input = [
    [4, 5, 1],
    [6, null, 3],
    [8, null, 4]
]

console.log(distributeGifts(input));

// Step by step result of the first few calculations:

// At position [0][0] we have the value 4
// Its neighbors are the values 5 and 6
// (4 + 5 + 6) / 3 = 5

// At position [0][1] we have the value 5
// Its neighbors are the values 4 and 1
// (5 + 4 + 1) / 3 = 3.33
// Math.round(3.33) = 3

// At position [0][2] we have the value 1
// Its neighbors are the values 5 and 3
// (1 + 5 + 3) / 3 = 3

// At position [1][0] we have the value 6
// Its neighbors are the values 4, 8
// (6 + 4 + 8 ) / 3 = 6

// At position [1][1] we have the value null
// Its neighbors are the values 5, 6 and 3
// (5 + 6 + 3) / 3 = 4.66
// Math.round(4.66) = 5
// ... and so on with the rest of the positions
/*[
[(4 + 5 + 6) / 3, (5 + 4 + 1) / 3, (1 + 5 + 3) / 3],
    [(6 + 4 + 8) / 3, (5 + 6 + 3) / 3, (3 + 1 + 4) / 3],
    [(8 + 6) / 2, (8 + 4) / 2, (4 + 3) / 2]
]*/

// Final result after rounding with Math.round()
/*    [
    [5, 3, 3],
        [6, 5, 3],
        [7, 6, 4]
    ]

 */
