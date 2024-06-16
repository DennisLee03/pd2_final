// scrape
document.getElementById('scrapeButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/scrape', {
        method: 'POST'
    })
    .then(response => response.text())
    .then(data => {
        alert('重新爬蟲成功');
    })
    .catch(error => console.error('Error:', error));
});

// get
document.getElementById('getButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/data', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

// delete
document.getElementById('deleteButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/delete', {
        method: 'DELETE'
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('sortButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/up_sort', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('sortDescButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/down_sort', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('filterNuggetsButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/nuggets', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('filterTartsButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/tarts', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('filterQQsButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/qqs', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('filterChickenButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/chicken', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('filterDaifukuButton').addEventListener('click', function() {
    fetch('http://localhost:8080/main/daifuku', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '';
        data.forEach(item => {
            const p = document.createElement('p');
            p.textContent = `Code: ${item.code}, Price: ${item.price}, Content: ${item.content}`;
            const img = document.createElement('img');
            img.src = item.imgUrl;
            img.alt = 'Image';
            //resultDiv.appendChild(p);
            resultDiv.appendChild(img);
        });
    })
    .catch(error => console.error('Error:', error));
});
