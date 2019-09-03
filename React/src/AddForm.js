import React, { Component } from 'react'
import { Redirect } from 'react-router-dom';
import Axios from 'axios';

export default class AddForm extends Component {
    constructor(props) {
        super(props);
        this.state = { response: "", isDispay: true };
    }
    componentWillReceiveProps() {
        this.setState({ response: "" })
    }
    render() {
        return (
            <div>
                {this.state.response === "" ?
                    <form id="formdata" onSubmit={(e) => this.handleSubmit(e)}>
                        <label>Name</label>
                        <input type="text" name="name" required /><br></br>
                        <label>Age</label>
                        <input type="number" name="age" required /><br></br>
                        <label>Email</label>
                        <input type="email" name="email" required /><br></br>
                        <input type="submit" name="submit" />
                    </form > :
                    <h4>{this.state.response}</h4>}
            </div>
        )
    }
    handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        let jsonObject = {
            "name": formData.get("name"),
            "age": formData.get("age"),
            "email": formData.get("email")
        };
        JSON.stringify(jsonObject);
        const headers = {
            'Content-Type': 'application/json',
          }
        Axios.post("http://localhost:8080/Data/storage", jsonObject, {
            headers: headers
        })
        .then(res => this.setState({ response: res.data }));
    }

}
