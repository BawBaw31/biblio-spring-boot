export function filterBooks(e) {
  const filters = document.querySelectorAll(".filter");
  for (let i = 0; i < filters.length; i++) {
    const filter = filters[i];
    filter.classList.remove("border-5");
  }
  e.target.classList.add("border-5");
  const type =
    e.target.attributes.id.nodeValue === "all"
      ? "card"
      : e.target.attributes.id.nodeValue;
  let container = document.getElementById("book-container");
  for (let i = 0; i < container.children.length; i++) {
    container.children[i].style.display = "flex";
    if (!container.children[i].classList.contains(type)) {
      container.children[i].style.display = "none";
    }
  }
}
