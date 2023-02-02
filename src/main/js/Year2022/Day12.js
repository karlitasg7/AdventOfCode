function selectSleigh(distance, sleighs) {
    const row = sleighs
        .reverse()
        .find(sleigh => sleigh.consumption * distance <= 20)
    return row ? row.name : null
}

const distance = 30
const sleighs = [
    {name: "Dasher", consumption: 0.3},
    {name: "Dancer", consumption: 0.5},
    {name: "Rudolph", consumption: 0.7},
    {name: "Midu", consumption: 1}
]

console.log(selectSleigh(distance, sleighs)); // => "Dancer"
console.log(
    selectSleigh(10, [
        {name: 'Pedrosillano', consumption: 1},
        {name: 'SamarJaffal', consumption: 5}
    ])
);
