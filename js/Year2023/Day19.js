function revealSabotage(store) {

    const result = []

    for (let i = 0; i < store.length; i++) {
        const row = store[i]
        const resultRow = []
        for (let j = 0; j < row.length; j++) {
            const cell = row[j]
            if (cell === '*') {
                resultRow.push('*')
            } else {
                let count = 0
                if (store[i - 1] && store[i - 1][j - 1] === '*') count++
                if (store[i - 1] && store[i - 1][j] === '*') count++
                if (store[i - 1] && store[i - 1][j + 1] === '*') count++
                if (store[i][j - 1] === '*') count++
                if (store[i][j + 1] === '*') count++
                if (store[i + 1] && store[i + 1][j - 1] === '*') count++
                if (store[i + 1] && store[i + 1][j] === '*') count++
                if (store[i + 1] && store[i + 1][j + 1] === '*') count++

                if (count === 0) count = ' '
                resultRow.push(count.toString())
            }
        }
        result.push(resultRow)
    }

    return result
}

const store = [
    ['*', ' ', ' ', ' '],
    [' ', ' ', '*', ' '],
    [' ', ' ', ' ', ' '],
    ['*', ' ', ' ', ' ']
]

console.log(revealSabotage(store))
/* Should display:
[
    ['*', '2', '1', '1'],
    ['1', '2', '*', '1'],
    ['1', '2', '1', '1'],
    ['*', '1', ' ', ' ']
]
*/
