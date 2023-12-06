function maxDistance(movements) {

    const text = movements
        .replaceAll('>', '')
        .replaceAll('<', '')

    let total = 0

    movements
        .split('')
        .forEach(m => {

            if (m === '>') {
                total++
            }
            if (m === '<') {
                total--
            }
        });

    return Math.abs(total) + text.length
}


console.log(maxDistance('>>*<')) // -> 2
console.log(maxDistance('<<<>')) // -> 2
console.log(maxDistance('>***>')) // -> 5
