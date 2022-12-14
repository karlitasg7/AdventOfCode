function getOptimalPath(path) {
    for (let i = path.length - 2; i >= 0; i--) {
        for (let j = 0; j <= i; j++) {
            path[i][j] += Math.min(path[i + 1][j], path[i + 1][j + 1]);
        }
    }
    return path[0][0];
}

console.log(getOptimalPath([[0], [7, 4], [2, 4, 6]])); // 8

console.log(getOptimalPath([[0], [2, 3]])); // 2
// 0 -> 2

console.log(getOptimalPath([[0], [3, 4], [9, 8, 1]])); // 5
// 0 -> 4 -> 1

console.log(getOptimalPath([[1], [1, 5], [7, 5, 8], [9, 4, 1, 3]])); // 8
// 1 -> 1 -> 5 -> 1
