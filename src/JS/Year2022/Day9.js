function countTime1(leds) {

    let unique = [...new Set(leds)];

    let totalTime = 0;
    let ledsBefore = [...leds];
    while (unique.length > 1) {
        if (leds[leds.length - 1] === 1) {
            leds[0] = 1;
        }
        for (let i = 1; i < leds.length; i++) {
            if (ledsBefore[i - 1] === 1) {
                leds[i] = 1;
            }
        }
        totalTime += 7;
        ledsBefore = [...leds];
        unique = [...new Set(leds)];
    }

    return totalTime;
}

function countTime(leds) {
    const repeatLeds = leds.join('').repeat(2);
    const zeros = repeatLeds.split('1')
    return zeros.reduce((max, str) => Math.max(max, str.length), 0) * 7;
}

console.log(countTime([1, 1, 1])); // 0

console.log(countTime([0, 1, 1, 0, 1])); // 7
// 7 segundos ya que en el primer cambio
// todas las luces se encendieron
// 0s: [0, 1, 1, 0, 1]
// 7s: [1, 1, 1, 1, 1]

console.log(countTime([0, 0, 0, 1])); // 21
// 21 segundos ya que necesita tres cambios:
// 0s: [0, 0, 0, 1]
// 7s: [1, 0, 0, 1]
// 14s: [1, 1, 0, 1]
// 21s: [1, 1, 1, 1]

console.log(countTime([0, 0, 1, 0, 0])); // 28
// 28 segundos ya que necesita cuatro cambios:
// 0s: [0, 0, 1, 0, 0]
// 7s: [0, 0, 1, 1, 0]
// 14s: [0, 0, 1, 1, 1]
// 21s: [1, 0, 1, 1, 1]
// 28s: [1, 1, 1, 1, 1]
