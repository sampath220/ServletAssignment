import React, { Component } from 'react'
import {Link} from 'react-router-dom'

export default class Header extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li><Link to='/addform'>Addform</Link></li>
                    <li><Link to='/display'>Search</Link></li>
                    <li><Link to='/sorting'>Sorting</Link></li>
                </ul>
            </div>
        )
    }
}
