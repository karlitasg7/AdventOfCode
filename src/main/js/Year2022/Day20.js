function howManyReindeers(reindeerTypes, gifts) {
    const reindeers = reindeerTypes
        .map(({type, weightCapacity}) =>
            ({type, capacity: weightCapacity})
        )
        .sort((a, b) => b.capacity - a.capacity)

    const getReindeersToSend = (weight) => {
        let num = 0;
        let currentWeight = weight;
        const filtered = reindeers.filter(({capacity}) => capacity < weight);
        let totalCapacity = filtered.reduce(
            (sum, {capacity}) => sum + capacity,
            0
        );

        return filtered.map(({type, capacity}) => {
            const coeff = currentWeight / totalCapacity | 0;
            currentWeight -= (coeff * totalCapacity);
            totalCapacity -= capacity;
            num += coeff;
            return {type, num};
        });
    }

    return gifts.map(
        ({country, weight}) =>
            ({country, reindeers: getReindeersToSend(weight)})
    )
}

const reindeerTypes = [
    {type: 'Nuclear', weightCapacity: 50},
    {type: 'Electric', weightCapacity: 10},
    {type: 'Gasoline', weightCapacity: 5},
    {type: 'Diesel', weightCapacity: 1}
]

const gifts = [
    {country: 'Spain', weight: 30},
    {country: 'France', weight: 17},
    {country: 'Italy', weight: 50}
]

console.log(howManyReindeers(reindeerTypes, gifts));
// [{
//   country: 'Spain',
//   reindeers: [
//     { type: 'Electric', num: 1 },
//     { type: 'Gasoline', num: 3 },
//     { type: 'Diesel', num: 5 }
//   ]
// }, {
//   country: 'France',
//   reindeers: [
//     { type: 'Electric', num: 1 },
//     { type: 'Gasoline', num: 1 },
//     { type: 'Diesel', num: 2 }
//   ]
//  }, {
//   country: 'Italy',
//   reindeers: [
//     { type: 'Electric', num: 3 },
//     { type: 'Gasoline', num: 3 },
//     { type: 'Diesel', num: 5 }
//   ]
// }]
