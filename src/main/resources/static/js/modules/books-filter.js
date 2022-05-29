export function filterBooks(e) {
  console.log(e.target.attributes.id);
  const type =
    e.target.attributes.id.nodeValue === "all"
      ? "card"
      : e.target.attributes.id.nodeValue;
  console.log(type);
  let container = document.getElementById("book-container");
  for (let i = 0; i < container.children.length; i++) {
    container.children[i].style.display = "flex";
    if (!container.children[i].classList.contains(type)) {
      container.children[i].style.display = "none";
    }
  }
}
