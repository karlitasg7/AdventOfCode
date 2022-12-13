function getCompleted(part, total) {
    const convertToSeconds = (time) => {
        const [h, m, s] = time.split(':');
        return (Number(h) * 3600) + (Number(m) * 60) + Number(s)
    };

    let secondsPart = convertToSeconds(part);
    let secondsTotal = convertToSeconds(total);

    let numPart = secondsPart;
    let numTotal = secondsTotal;

    while (numTotal) [numPart, numTotal] = [numTotal, numPart % numTotal];
    const divisor = numPart;

    const resultCompleted = secondsPart / divisor
    const resultTotal = secondsTotal / divisor

    return `${resultCompleted}/${resultTotal}`;

}

console.log(getCompleted('01:00:00', '03:00:00')); // '1/3'
console.log(getCompleted('02:00:00', '04:00:00')); // '1/2'
console.log(getCompleted('01:00:00', '01:00:00')); // '1/1'
console.log(getCompleted('00:10:00', '01:00:00')); // '1/6'
console.log(getCompleted('01:10:10', '03:30:30')); // '1/3'
console.log(getCompleted('03:30:30', '05:50:50')); // '3/5
