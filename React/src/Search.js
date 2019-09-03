import React, { Component } from 'react'
import Axios from 'axios'
export default class Display extends Component {
    constructor() {
        super();
        this.state = { data: [], isDisplay: false };
    }
    render() {
        return (
            <div>
                <form onSubmit={(e) => this.handleSubmit(e)}>
                    <label>Name</label>
                    <input type="text" name="name" />
                    <label>Age</label>
                    <input type="number" name="age" />
                    <label>Email</label>
                    <input type="email" name="email" /><br></br>
                    <input type="submit" name="submit" /><br/><br/>
                </form>
                {this.state.isDisplay && <table>
                    <tbody>
                        <tr>{this.printHeader()}</tr>
                        {this.printTable()}
                    </tbody>
                </table>}
            </div>
        )
    }
    handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        console.log(formData.get("name"));
        let jsonObject = {
            "name": formData.get("name"),
            "age": formData.get("age"),
            "email": formData.get("email")
        };
        Axios({
            url: "http://localhost:8080/Data/search",
            method: "get",
            params: jsonObject
        })
            .then(res => {
                console.log(res);
                this.setState({ isDisplay: true, data: res.data });
            }).catch(err => {
                console.log(err);
            })
    }
    printHeader() {
        let header = Object.keys(this.state.data[0])
        return header.map((key, index) => {
            return <th key={index}>{key.toUpperCase()}</th>
        })
    }
    printTable() {
        return this.state.data.map((person, index) => {
            const { name, age, email } = person
            return (
                <tr>
                    <td>{name}</td>
                    <td>{age}</td>
                    <td>{email}</td>
                </tr>
            )
        })
    }

}
