const fs = require('fs');
const INPUT = fs.readFileSync('input.txt', 'utf-8').split('\n');
const PERSON_ATTRIBUTES_REGEX = /(\w+) would (\w+) (\d+) happiness units by sitting next to (\w+)./;
const NEW_PERSON = 'XX';

const permute = input => {
    const array = Array.from(input);
    const permute = (res, item, key, arr) => {
        return res.concat(arr.length > 1 &&
            arr
                .slice(0, key)
                .concat(arr.slice(key + 1))
                .reduce(permute, [])
                .map(perm => [item].concat(perm)) || item
        );
    };

    return array.reduce(permute, []);
};

const getPersonAttributes = input => {
    return input
        .filter(x => x !== '')
        .reduce((map, person) => {
            const parsed = person.match(PERSON_ATTRIBUTES_REGEX);

            const name = parsed[1];
            const isLose = parsed[2] === 'lose';
            const count = +parsed[3];
            const neighbour = parsed[4];

            map.set(`${name} -> ${neighbour}`, isLose ? -count : count);
            map.set(`${NEW_PERSON} -> ${name}`, 0);
            map.set(`${name} -> ${NEW_PERSON}`, 0);

            return map;
        }, new Map());
};

const getAttendees = input => {
    return input
        .filter(x => x !== '')
        .reduce((set, person) => {
            const parsed = person.match(PERSON_ATTRIBUTES_REGEX);
            return set.add(parsed[1]);
        }, new Set())
        .add(NEW_PERSON);
};

const personAttributes = getPersonAttributes(INPUT);
const allPossiblePermutations = permute(getAttendees(INPUT));

const totalHappiness = allPossiblePermutations
    .reduce((totalHappiness, permutation) => {
        const total = permutation
            .reduce((total, person, index, arr) => {
                const leftOne = arr[index - 1 < 0 ? arr.length - 1 : index - 1];
                const rightOne = arr[index + 1 > arr.length - 1 ? 0 : index + 1];

                total += personAttributes.get(`${person} -> ${leftOne}`);
                total += personAttributes.get(`${person} -> ${rightOne}`);

                return total;
            }, 0);

        return total > totalHappiness ? total : totalHappiness;
    }, 0);

console.log(totalHappiness);
