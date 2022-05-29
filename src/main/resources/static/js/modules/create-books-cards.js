export function createBooksCards(books) {
  let container = document.getElementById("book-container");

  for (const book in books) {
    container.appendChild(createCard(books[book]));
  }

  function createCard(book) {
    const card = document.createElement("div");
    card.classList.add("card", book.type);
    card.style.width = "18rem";

    const img = document.createElement("img");
    img.classList.add("card-img-top");
    img.src = book.photo;
    img.alt = book.title;

    const body = document.createElement("div");
    body.classList.add("card-body");

    const title = document.createElement("h5");
    title.classList.add("card-title");
    title.innerText = book.title;

    const writer = document.createElement("p");
    writer.classList.add("card-text");
    writer.innerText = book.writer;

    const btn = document.createElement("a");
    btn.classList.add("btn", "btn-primary");
    btn.innerText = "En savoir plus !";
    btn.href = "#";

    body.appendChild(title);
    body.appendChild(writer);
    body.appendChild(btn);

    card.appendChild(img);
    card.appendChild(body);

    return card;
  }
};
