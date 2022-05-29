import { createBooksCards } from "./modules/create-books-cards.js";
import { filterBooks } from "./modules/books-filter.js";

document.addEventListener("DOMContentLoaded", (event) => {
  // Create books cards and add them to the DOM
  const books = [
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "comedy",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "fantastic",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "romance",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "comedy",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "fantastic",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "comedy",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "fantastic",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "comedy",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "fantastic",
    },
    {
      title: "Shingeki no Kyojin",
      writer: "Hajime Isayama",
      photo: "/img/attaquetitan.jpg",
      type: "combat",
    },
  ];
  createBooksCards(books);

  // Add event listener to the filter buttons
  let booksCategoryBtns = document.querySelectorAll(".category-btn");
  for (let i = 0; i < booksCategoryBtns.length; i++) {
    const btn = booksCategoryBtns[i];
    btn.onclick = filterBooks;
  }
});
