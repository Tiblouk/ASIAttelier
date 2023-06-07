
function buy(card, id_palyer) {
  console.log("buy");
}

async function getCardsList() {
    let cardList = [];
    let url = '/cards';

    let template = document.querySelector("#row");
    fetch(url, {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE',
          'Access-Control-Allow-Headers': 'Content-Type'
        }
      })
        .then(response => response.json())
        .then(data => {
          console.log(data);
          data.forEach(card => {
            let clone = document.importNode(template.content, true);

            newContent = clone.firstElementChild.innerHTML
                .replace(/{{id}}/g, card.id)
                .replace(/{{img_src}}/g, "card.png")
                .replace(/{{color}}/g, card.color)
                .replace(/{{number}}/g, card.number)
                .replace(/{{price}}/g, card.price);
            clone.firstElementChild.innerHTML = newContent;
        
            let cardContainer = document.querySelector("#tableContent");
            cardContainer.appendChild(clone);
            document.getElementById(card.id).onclick = function(e) {
              if(confirm("Click to confirm or cancel")){
                buy(card.id, 2)
              }
              // window.location.href = '/'
            }
          });

        })
        .catch(error => {
          console.log('Error:', error);
        });
      
    $(function () {
    $("#card").load("./part/card-show.html");
    });
}

getCardsList();
