function executeCommands(commands) {

    let response = new Array(8).fill(0);
    let position = 0;

    let commandAction = {
        MOV: (params, param0, param1) => {
            if (params[0].startsWith("V")) {
                response[param1] = response[param0];
            } else {
                response[param1] = param0;
            }

            position++;
        },
        ADD: (params, param0, param1) => {
            response[param0] = response[param0] + response[param1];
            response[param0] = response[param0] % 256;

            position++;
        },
        DEC: (params, param0) => {
            if (response[param0] === 0) {
                response[param0] = 255;
            } else {
                response[param0] -= 1;
            }
            position++;
        },
        INC: (params, param0) => {
            if (response[param0] === 255) {
                response[param0] = 0;
            } else {
                response[param0] += 1;
            }
            position++;
        },
        JMP: (params, param0) => {
            if (response[0] === 0) {
                position++;
            } else {
                position = param0;
            }
        },
    };

    while (position < commands.length) {

        let x = commands[position];

        let command = x.split(" ")[0];
        let params = x.split(" ")[1].split(",");

        let param0 = parseInt(params[0].replace("V", ""));
        let param1 = 0;
        if (params.length > 1) {
            param1 = parseInt(params[1].replace("V", ""));
        }

        commandAction[command](params, param0, param1);
    }

    return response;
}

console.log(
    executeCommands([
        'MOV 5,V00',  // V00 es 5
        'MOV 10,V01', // V01 es 10
        'DEC V00',    // V00 ahora es 4
        'ADD V00,V01' // V00 = V00 + V01 = 14
    ])
);
// Output: [14, 10, 0, 0, 0, 0, 0]


console.log(
    executeCommands([
        'MOV 255,V00', // V00 es 255
        'INC V00',     // V00 es 256, desborda a 0
        'DEC V01',     // V01 es -1, desborda a 255
        'DEC V01'      // V01 es 254
    ])
);

// Output: [0, 254, 0, 0, 0, 0, 0]


console.log(
    executeCommands([
        'MOV 10,V00', // V00 es 10
        'DEC V00',    // decrementa V00 en 1  <---┐
        'INC V01',    // incrementa V01 en 1      |
        'JMP 1',      // bucle hasta que V00 sea 0 ----┘
        'INC V06'     // incrementa V06 en 1
    ])
);
// Output: [ 0, 10, 0, 0, 0, 0, 1, 0 ]

console.log(
    executeCommands([
        'MOV 10,V00',
        'MOV V00,V01',
        'MOV V01,V02',
        'MOV V02,V03',
        'MOV V03,V04'
    ])
);
