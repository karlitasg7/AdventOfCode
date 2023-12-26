function organizeChristmasDinner(dishes) {

    const map = new Map()
    let result = []

    for (const dish of dishes) {
        for (let i = 0; i < dish.length; i++) {

            if (i > 0) {
                if (!map.has(dish[i])) {
                    map.set(dish[i], [])
                }

                map.get(dish[i]).push(dish[0])
            }
        }
    }

    const sortedMap = new Map([...map.entries()]
        .sort((a, b) => a[0].localeCompare(b[0])));


    sortedMap.forEach((value, key) => {
        
        if (value.length > 1) {
            result.push([key, ...value.sort()])
        }

    })

    return result
}

const dishes = [
    ["christmas turkey", "turkey", "sauce", "herbs"],
    ["cake", "flour", "sugar", "egg"],
    ["hot chocolate", "chocolate", "milk", "sugar"],
    ["pizza", "sauce", "tomato", "cheese", "ham"],
]

console.log(organizeChristmasDinner(dishes));

/*

"sauce" is in 2 dishes: "christmas turkey" and "pizza".
"sugar" is in 2 dishes: "cake" and "hot chocolate".
The rest of the ingredients only appear in one dish, so we do not show them.

We show "sauce" first because alphabetically it comes before "sugar".
And the dishes of each ingredient are also alphabetically ordered.

[
  ["sauce", "christmas turkey", "pizza"],
  ["sugar", "cake", "hot chocolate"]
]
*/
