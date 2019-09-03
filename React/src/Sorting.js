import React, { Component } from 'react'
import Axios from 'axios'
export default class Sorting extends Component {
    constructor() {
        super();
        this.state = { data: [], isDisplay: false, isChecked: true };
    }
    render() {
        return (
            <div>
                <form onSubmit={(e) => this.handleSubmit(e)}>
                    <label>Choose field to filter:</label>
                    <select name="field">
                        <option value="name">Name</option>
                        <option value="age">Age</option>
                        <option value="email">Email</option>
                    </select>
                    <input type="radio" name="order" value="asc" checked />
                    <label >Ascending</label>
                    <input type="radio" name="order" value="desc" />
                    <label >Descending</label>
                    <input type="submit" value="submit" />
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
        let jsonObject = {
            field: formData.get("field"),
            order: formData.get("order"),
        };

        Axios({
            url: "http://localhost:8080/Data/sorting",
            method: "get",
            params: jsonObject
        })
            .then(res => {
                console.log("hdihi");
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
