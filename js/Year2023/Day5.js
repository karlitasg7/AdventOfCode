function cyberReindeer(road, time) {

    const result = []

    result.push(road)

    let lastRoad = road
    let indexOfS = road.indexOf('S')
    let backToStar = false

    for (let i = 1; i < time; i++) {

        let newRoad = lastRoad.split('')

        if (i >= 5) {
            newRoad = newRoad.map(s => s.replace('|', '*'))
        }

        if (newRoad[indexOfS + 1] === '.') {
            newRoad[indexOfS + 1] = 'S'

            if (backToStar) {
                newRoad[indexOfS] = '*'
                backToStar = false
            } else {
                newRoad[indexOfS] = '.'
            }

        } else if (newRoad[indexOfS + 1] === '*') {
            newRoad[indexOfS + 1] = 'S'

            if (backToStar) {
                newRoad[indexOfS] = '*'
                backToStar = false
            } else {
                newRoad[indexOfS] = '.'
            }

            backToStar = true
        }

        result.push(newRoad.join(''))
        lastRoad = newRoad.join('')
        indexOfS = newRoad.indexOf('S')
    }

    return result
}

const road = 'S..|...|..'
const time = 10 // units of time
const result = cyberReindeer(road, time)

console.log(result)

/* -> result:
[
  'S..|...|..', // initial state
  '.S.|...|..', // sled advances on the road
  '..S|...|..', // sled advances on the road
  '..S|...|..', // sled stops at the barrier
  '..S|...|..', // sled stops at the barrier
  '...S...*..', // barrier opens, sled advances
  '...*S..*..', // sled advances on the road
  '...*.S.*..', // sled advances on the road
  '...*..S*..', // sled advances on the road
  '...*...S..', // passes through the open barrier
]
*/
