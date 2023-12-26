function drawClock(time) {

    const map = new Map();

    map.set('0', [
        ['*', '*', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', '*', '*'],
    ]);

    map.set('1', [
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
    ]);

    map.set('2', [
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        ['*', '*', '*'],
        ['*', ' ', ' '],
        ['*', ' ', ' '],
        ['*', '*', '*'],
    ]);

    map.set('3', [
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        ['*', '*', '*'],
    ]);

    map.set('4', [
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
    ]);

    map.set('5', [
        ['*', '*', '*'],
        ['*', ' ', ' '],
        ['*', ' ', ' '],
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        ['*', '*', '*'],
    ]);

    map.set('6', [
        ['*', '*', '*'],
        ['*', ' ', ' '],
        ['*', ' ', ' '],
        ['*', '*', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', '*', '*'],
    ]);

    map.set('7', [
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
    ]);

    map.set('8', [
        ['*', '*', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', '*', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', '*', '*'],
    ]);

    map.set('9', [
        ['*', '*', '*'],
        ['*', ' ', '*'],
        ['*', ' ', '*'],
        ['*', '*', '*'],
        [' ', ' ', '*'],
        [' ', ' ', '*'],
        ['*', '*', '*'],
    ]);

    map.set(':', [
        [' '],
        [' '],
        ['*'],
        [' '],
        ['*'],
        [' '],
        [' '],
    ]);

    map.set('empty', [
        [' '],
        [' '],
        [' '],
        [' '],
        [' '],
        [' '],
        [' '],
    ]);

    const [hour, minute] = time.split(':');
    const [hour1, hour2] = hour.split('');
    const [minute1, minute2] = minute.split('');

    const clock = new Array(7)

    map.get(hour1).forEach((row, index) => {
        if (!clock[index]) {
            clock[index] = [];
        }
        clock[index] = clock[index].concat(row);
    });
    map.get('empty').forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get(hour2).forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get('empty').forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get(':').forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get('empty').forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get(minute1).forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get('empty').forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });
    map.get(minute2).forEach((row, index) => {
        clock[index] = clock[index].concat(row);
    });

    let text = '';
    for (let i = 0; i < clock.length; i++) {
        for (let j = 0; j < clock[i].length; j++) {
            text += clock[i][j];
        }
        text += '\n';
    }
    console.log(text);

    return clock
}

console.log(drawClock('01:30'));
/*
    [
        ['*', '*', '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', '*', '*', ' ', '*', '*', '*'],
        ['*', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', '*'],
        ['*', ' ', '*', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ', ' ', '*', ' ', '*', ' ', '*'],
        ['*', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', '*', '*', ' ', '*', ' ', '*'],
        ['*', ' ', '*', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ', ' ', '*', ' ', '*', ' ', '*'],
        ['*', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', '*'],
        ['*', '*', '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', '*', '*', ' ', '*', '*', '*']
    ]
*/
