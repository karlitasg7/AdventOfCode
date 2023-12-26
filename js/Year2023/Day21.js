function findBalancedSegment(message) {

    let maxLen = 0;
    let startIdx = -1;
    let endIdx = -1;

    for (let i = 0; i < message.length; i++) {
        let balance = 0;
        for (let j = i; j < message.length; j++) {
            if (message[j] === 0) {
                balance--;
            } else {
                balance++;
            }

            if (balance === 0 && j - i + 1 > maxLen) {
                maxLen = j - i + 1;
                startIdx = i;
                endIdx = j;
            }
        }
    }

    if (startIdx === -1) {
        return [];
    }
    return [startIdx, endIdx];

}

console.log(findBalancedSegment([1, 1, 0, 1, 1, 0, 1, 1]));
//                         |________|
// position of segment:    [2, 5]
// longest balanced
// of 0s and 1s

console.log(findBalancedSegment([1, 1, 0]));
//                      |__|
//                     [1, 2]

console.log(findBalancedSegment([1, 1, 1]));
// no balanced segments: []
