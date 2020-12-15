var roomOptions = {
    valueNames: ['category', 'idRoom', 'roomName', 'roomNumber', 'status']
};

var roomList = new List('rooms', roomOptions);

var categoryOptions = {
    valueNames: ['categories-name', 'number-of-places', 'wi-fi', 'breakfast',
                 'dinner', 'jacuzzi','tv','price',]
};

var categoryList = new List('room-categories', categoryOptions);