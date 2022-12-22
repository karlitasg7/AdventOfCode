function checkStepNumbers1(systemNames, stepNumbers) {

    let mapSystems = {};

    systemNames.forEach(x => {
        mapSystems[x] = [];
    });

    for (let i = 0; i < stepNumbers.length; i++) {
        mapSystems[systemNames[i]].push(stepNumbers[i]);
    }

    for (let key in mapSystems) {
        let last = 0;

        for (let n = 0; n < mapSystems[key].length; n++) {
            if (mapSystems[key][n] < last) {
                return false;
            }
            last = mapSystems[key][n];
        }
    }

    return true;
}

function checkStepNumbers(systemNames, stepNumbers) {
    const mapSystems = {};

    return systemNames
        .every((systemName, index) => {
            if (mapSystems[systemName] &&
                mapSystems[systemName] >= stepNumbers[index]) {
                return false;
            }

            mapSystems[systemName] = stepNumbers[index];
            return true;

        });
}

const systemNames = ["tree_1", "tree_2", "house", "tree_1", "tree_2", "house"]
const stepNumbers = [1, 33, 10, 2, 44, 20]

console.log(checkStepNumbers(systemNames, stepNumbers)); // => true

// tree_1 tiene los pasos: [1, 2]
// tree_2 tiene los pasos: [33, 44]
// house tiene los pasos: [10, 20]

// true: Los pasos de cada sistema están en orden estrictamente creciente

console.log(checkStepNumbers(["tree_1", "tree_1", "house"], [2, 1, 10])); // => false

// tree_1 tiene los pasos: [2, 1]
// house tiene los pasos: [10]

// false: tree_1 tiene los pasos de forma decreciente
