const URL = 'http://localhost:8080';
let entries = [];
let jiras = [];
let breaks = [];
let categories = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    const jiraStat = {};
    jiraStat['jiraNumber'] = formData.get('jnumber');
    jiraStat['achievement'] = formData.get('achievement')

    const category = {};
    category['text'] = formData.get('admin');
    category['text'] = formData.get('itsupport');
    category['text'] = formData.get('projekt');

    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    });
};

const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createForm');
    createEntryForm.addEventListener('submit', createEntry, createBreak);
    indexEntries();
    indexBreak();
});


const renderBreaks = () => {
    const display = document.querySelector('#breaksDisplay');
    display.innerHTML = '';
    entries.forEach((brake) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(brake.id));
        row.appendChild(createCell(String(brake.hours)));
        display.appendChild(row);
    });
};

const createBreak = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);

    const brake = {};
    brake['hours'] = formData.get('breaktime');

    fetch(`${URL}/breaks`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(brake)
    }).then((result) => {
        result.json().then((brake) => {
            breaks.push(brake);
            renderBreaks();
        });
    });
};

const indexBreak = () => {
    fetch(`${URL}/breaks`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            breaks = result;
            renderBreaks();
        });
    });
    renderBreaks();
};


