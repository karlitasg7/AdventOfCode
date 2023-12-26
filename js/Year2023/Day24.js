function getStaircasePaths(steps, maxJump) {

    if (steps <= 0) return [[]]

    const paths = []

    const f = (s, g) => {
        if (s === 0) return paths.push(g)

        for (let i = 1; i <= Math.min(s, maxJump); i++) {
            if (s > 0) f(s - i, g.concat([i]))
        }
    }

    f(steps, [])

    return paths
}

console.log(getStaircasePaths(2, 1)); // [[1, 1]]
console.log(getStaircasePaths(3, 3)); // [[1, 1, 1], [1, 2], [2, 1], [3]]
console.log(getStaircasePaths(5, 1)); // [[1, 1, 1, 1, 1]]
console.log(getStaircasePaths(5, 2));
/*
[
  [1, 1, 1, 1, 1],
  [1, 1, 1, 2],
  [1, 1, 2, 1],
  [1, 2, 1, 1],
  [1, 2, 2],
  [2, 1, 1, 1],
  [2, 1, 2],
  [2, 2, 1],
]
*/
