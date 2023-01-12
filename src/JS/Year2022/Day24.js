function canExit(maze) {
    const visit = (maze = [], i, j) => {
        if (maze[i][j] === 'E') return true;
        if (maze[i][j] !== ' ') return false;

        maze[i][j] = 'X';

        return (i + 1 < HEIGHT && visit(maze, i + 1, j))
            || (i - 1 >= 0 && visit(maze, i - 1, j))
            || (j + 1 < WIDTH && visit(maze, i, j + 1))
            || (j - 1 >= 0 && visit(maze, i, j - 1));
    }

    const WIDTH = maze[0].length;
    const HEIGHT = maze.length;

    const joined = maze.map(row => row.join('')).join('');
    const index = joined.indexOf('S');
    const i = index / WIDTH | 0;
    const j = index % WIDTH;

    maze[i][j] = ' ';

    let result = visit(maze, i, j);
    return result;
}

console.log(
    canExit([
        [' ', ' ', 'W', ' ', 'S'],
        [' ', ' ', ' ', ' ', ' '],
        [' ', ' ', ' ', 'W', ' '],
        ['W', 'W', ' ', 'W', 'W'],
        [' ', ' ', ' ', ' ', 'E']
    ]) // -> true
);

// Se puede salir porque empezamos en [0, 4]
// y hay un camino hasta la salida que es [4, 4]
