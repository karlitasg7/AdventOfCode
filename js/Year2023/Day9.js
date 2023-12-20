function adjustLights(lights) {
    if (lights.length < 2) return 0

    let count = 0
    let count2 = 0
    let lastLight = lights[0]

    for (const i in lights) {
        lights[i] === lastLight ? count++ : count2++
        lastLight = lastLight === '🔴' ? '🟢' : '🔴'
    }

    return Math.min(count, count2)

}

console.log(adjustLights(["🔴", "🔴", "🟢", "🔴", "🟢"]))

console.log(adjustLights(['🟢', '🔴', '🟢', '🟢', '🟢'])); // -> 1 (you change the fourth light to 🔴)

console.log(adjustLights(['🔴', '🔴', '🟢', '🟢', '🔴'])); // -> 2 (you change the second light to 🟢 and the third to 🔴)

console.log(adjustLights(['🟢', '🔴', '🟢', '🔴', '🟢'])); // -> 0 (they are already alternating)

console.log(adjustLights(['🔴', '🔴', '🔴'])); // -> 1 (you change the second light to 🟢)
