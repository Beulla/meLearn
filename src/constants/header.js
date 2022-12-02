import { render } from "@testing-library/react";
import { Fragment } from "react";
import {} from "../styles/headers.css"
export default function Header(){
    render(
        <Fragment>
            <div id="navbar">
                <Link to="/courses">Courses</Link>
                <Link to="/departments">Departments</Link>
                <Link to="/teachers">Teachers</Link>
            </div>
        </Fragment>
    )
}