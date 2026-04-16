// 🔥 Page Load
document.addEventListener("DOMContentLoaded", function () {
    console.log("App Loaded 🚀");
});


// 🔥 Delete Confirm
function confirmDelete() {
    return confirm("Are you sure you want to delete this content?");
}


// 🔥 Attach confirm to all delete buttons
document.addEventListener("DOMContentLoaded", function () {
    let deleteBtns = document.querySelectorAll(".btn-delete");

    deleteBtns.forEach(btn => {
        btn.addEventListener("click", function (e) {
            if (!confirmDelete()) {
                e.preventDefault();
            }
        });
    });
});


// 🔥 Form Validation (Add Content)
document.addEventListener("DOMContentLoaded", function () {
    let form = document.querySelector("form");

    if (form) {
        form.addEventListener("submit", function (e) {

            let title = document.querySelector("input[name='title']");
            let content = document.querySelector("textarea[name='content']");

            if (title && title.value.trim() === "") {
                alert("Title cannot be empty!");
                e.preventDefault();
            }

            if (content && content.value.trim() === "") {
                alert("Content cannot be empty!");
                e.preventDefault();
            }
        });
    }
});


// 🔥 Button Loading Effect
document.addEventListener("DOMContentLoaded", function () {
    let buttons = document.querySelectorAll("button");

    buttons.forEach(btn => {
        btn.addEventListener("click", function () {
            btn.innerText = "Please wait...";
        });
    });
});


// 🔥 Smooth Scroll
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener("click", function (e) {
        e.preventDefault();

        document.querySelector(this.getAttribute("href"))
            .scrollIntoView({
                behavior: "smooth"
            });
    });
});


// 🔥 Auto Hide Message (Success/Error)
setTimeout(() => {
    let msg = document.querySelector(".alert");
    if (msg) {
        msg.style.display = "none";
    }
}, 3000);
// 🔥 Page Load
document.addEventListener("DOMContentLoaded", function () {
    console.log("App Loaded 🚀");
});


// =============================
// 🔐 LOGIN FORM VALIDATION
// =============================
let loginForm = document.querySelector("#loginForm");

if (loginForm) {
    loginForm.addEventListener("submit", function (e) {

        let email = document.querySelector("input[name='email']");
        let password = document.querySelector("input[name='password']");

        if (email.value.trim() === "" || password.value.trim() === "") {
            alert("Please fill all login fields!");
            e.preventDefault();
        }
    });
}


// =============================
// 📝 REGISTER FORM VALIDATION
// =============================
let signupForm = document.querySelector("#signupForm");

if (signupForm) {
    signupForm.addEventListener("submit", function (e) {

        let name = document.querySelector("input[name='name']");
        let email = document.querySelector("input[name='email']");
        let password = document.querySelector("input[name='password']");

        if (name.value.trim() === "" ||
            email.value.trim() === "" ||
            password.value.trim() === "") {

            alert("All fields are required!");
            e.preventDefault();
        }

        if (password.value.length < 4) {
            alert("Password must be at least 4 characters!");
            e.preventDefault();
        }
    });
}


// =============================
// 🗑 DELETE CONFIRM
// =============================
document.addEventListener("DOMContentLoaded", function () {

    let deleteBtns = document.querySelectorAll(".btn-delete");

    deleteBtns.forEach(btn => {
        btn.addEventListener("click", function (e) {

            let confirmDelete = confirm("Are you sure you want to delete?");

            if (!confirmDelete) {
                e.preventDefault();
            }
        });
    });
});


// =============================
// ✍️ ADD POST VALIDATION
// =============================
let postForm = document.querySelector("form");

if (postForm) {
    postForm.addEventListener("submit", function (e) {

        let title = document.querySelector("input[name='title']");
        let content = document.querySelector("textarea[name='content']");

        if (title && title.value.trim() === "") {
            alert("Title cannot be empty!");
            e.preventDefault();
        }

        if (content && content.value.trim() === "") {
            alert("Content cannot be empty!");
            e.preventDefault();
        }
    });
}


// =============================
// 🔘 BUTTON LOADING EFFECT
// =============================
let buttons = document.querySelectorAll("button");

buttons.forEach(btn => {
    btn.addEventListener("click", function () {
        btn.innerText = "Please wait...";
    });
});


// =============================
// 📱 ABOUT PAGE SOCIAL CLICK MSG
// =============================
let socialLinks = document.querySelectorAll(".social-link");

socialLinks.forEach(link => {
    link.addEventListener("click", function () {
        console.log("Opening social profile...");
    });
});


// =============================
// 🔔 SUCCESS MESSAGE AUTO HIDE
// =============================
setTimeout(() => {
    let msg = document.querySelector(".alert");
    if (msg) {
        msg.style.display = "none";
    }
}, 3000);


// =============================
// ✨ SMOOTH SCROLL
// =============================
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener("click", function (e) {
        e.preventDefault();

        document.querySelector(this.getAttribute("href"))
            .scrollIntoView({
                behavior: "smooth"
            });
    });
});
