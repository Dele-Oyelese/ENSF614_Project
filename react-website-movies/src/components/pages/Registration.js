import React from "react";
import "../../App.css";
import { useState } from "react";

function Registration() {
    const [name, setname] = useState("");
    const [address, setaddress] = useState("");
    const [password, setpassword] = useState("");
    const [email, setemail] = useState("");
    const [creditcard, setcreditcard] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        const user = { name, address, password, email, creditcard };
        console.log(JSON.stringify(user));
        fetch("...", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user),
        }).then(() => {
            console.log("i just did something");
            setname("");
            setaddress("");
            setpassword("");
            setemail("");
            setcreditcard("");

        });
    };

    return (

        <div className="movie">

            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Name: will be your username</label>
                    <input
                        type="text"
                        value={name}
                        onChange={(e) => setname(e.target.value)}
                        className="form-control"
                        placeholder="Enter Your Name, e.g.: John"
                    ></input>
                </div>
                <div className="form-group">
                    <label>Address</label>
                    <input
                        type="text"
                        value={address}
                        onChange={(e) => setaddress(e.target.value)}
                        className="form-control"
                        placeholder="Enter your address: 123 Block X, T6X6G8, Calgary, AB"
                    ></input>
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setpassword(e.target.value)}
                        className="form-control"
                        placeholder="Enter a password"
                    ></input>
                </div>

                <div className="form-group">
                    <label>Email</label>
                    <input
                        type="text"
                        value={email}
                        onChange={(e) => setemail(e.target.value)}
                        className="form-control"
                        placeholder="Enter your email: e.g john.smith@gmail.com"
                    ></input>
                </div>

                <div className="form-group">
                    <label>Credit Card Number</label>
                    <input
                        type="text"
                        value={creditcard}
                        onChange={(e) => setcreditcard(e.target.value)}
                        className="form-control"
                        placeholder="Enter credit card number: e.g 1234 5678 9101 1213"
                    ></input>
                </div>

                <button
                    type="submit"
                    className="btn btn-primary"
                >
                    Register
                </button>
            </form>

        </div>


    );
}

export default Registration;
