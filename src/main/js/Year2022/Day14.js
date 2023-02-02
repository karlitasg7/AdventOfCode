function getOptimalPath(path) {
    return path.reduceRight((previous, current) => {
        return current.map((val, index) => {
            return val + Math.min(previous[index], previous[index + 1])
        })
    })[0];
}

console.log(getOptimalPath([[0], [7, 4], [2, 4, 6]])); // 8

console.log(getOptimalPath([[0], [2, 3]])); // 2
// 0 -> 2

console.log(getOptimalPath([[0], [3, 4], [9, 8, 1]])); // 5
// 0 -> 4 -> 1

console.log(getOptimalPath([[1], [1, 5], [7, 5, 8], [9, 4, 1, 3]])); // 8
// 1 -> 1 -> 5 -> 1
