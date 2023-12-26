function travelDistance(map) {
    let mapWidth = map.indexOf('\n')
    let linearMap = map.replaceAll('\n', '')
    let i = 1
    let nextKid = linearMap.indexOf(`${i}`)
    let santaPos = linearMap.indexOf('S')
    let distance = 0

    while (nextKid !== -1) {
        let santaRow = Math.floor(santaPos / mapWidth)
        let kidRow = Math.floor(nextKid / mapWidth)
        let highest = [santaPos, nextKid][+(santaRow >= kidRow)]
        let lowest = [santaPos, nextKid][+(santaRow < kidRow)]

        highest += [santaRow - kidRow, kidRow - santaRow][+(santaRow < kidRow)] * mapWidth

        distance += [santaRow - kidRow, kidRow - santaRow][+(santaRow < kidRow)]
        distance += [highest - lowest, lowest - highest][+(highest < lowest)]

        i++
        santaPos = nextKid
        nextKid = linearMap.indexOf(`${i}`)
    }

    return distance
}

const map = `.....1....
..S.......
..........
....3.....
......2...`

const result = travelDistance(map)
console.log(result) // -> 12 km
/*
From S to kid 1: 4 moves
From kid 1 to 2: 5 moves
From kid 2 to 3: 3 moves
Total: 12 moves
*/

const result2 = travelDistance(`..S.1...`)
console.log(result2) // -> 2
