var roomOptions = {
    valueNames: ['category', 'idRoom', 'roomName', 'roomNumber', 'status']
};

var roomList = new List('rooms', roomOptions);

var modelOptions = {
    valueNames: ['brand-name', 'model-name', 'generation', 'production-year',
                 'doors', 'seats','maximum-speed']
};

var modelList = new List('car-models', modelOptions);