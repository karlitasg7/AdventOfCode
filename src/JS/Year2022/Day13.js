function getFilesToBackup(lastBackup, changes) {
    return [...new Set(changes
        .filter(x => x[1] > lastBackup)
        .map(x => x[0])
    )]
        .sort((a, b) => a - b);
}


const lastBackup = 1546300800
const changes = [
    [2, 1546300800],
    [3, 1546301100],
    [1, 1546300800],
    [1, 1546300900],
    [1, 1546301000],
]

console.log(getFilesToBackup(lastBackup, changes)); // => [ 1, 3 ]
