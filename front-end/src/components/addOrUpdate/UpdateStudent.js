import { useEffect, useState } from "react"
import { Button, Form, FormControl, FormGroup } from "react-bootstrap";
import { useNavigate, useParams } from "react-router";
import './UpdateStudent.css'


const UpdateStudent = () => {
    
    const {id} = useParams();
    const navigate = useNavigate();

    const [formData, setFormData] = useState ({
        name:"",
        address:"",
    })

const handleInputChange = (event) => {
    const {name, value} = event.target
    setFormData({
        ...formData,
        [name]:value,
    })
};

    useEffect(() => {
        const fetchStudent = async () => {
            try {
                const response = await fetch(`http://localhost:8080/student/${id}`)
                const data = await response.json();
                setFormData(data);
            } catch (error) {
                console.log("Error fetching user:", error.message);
            }
        }
        fetchStudent();
    }, [id]);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch(`http://localhost:8080/student/${id}`, {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData),
            });
            const data = await response.json();
            console.log("User updated: ", data);
            navigate(`/student`)
        } catch (error) {
            console.error("Error updating user:", error.message);
        }
    } 
    return (
        <>
            <div className="center-form">
                <h1>Edit Student</h1>
                <Form onSubmit={handleSubmit}>
                    <FormGroup controlId="formBasicName">
                        <FormControl
                        type="text"
                        name="name"
                        placeholder="Enter name"
                        value={formData.name}
                        onChange={handleInputChange}/>
                    </FormGroup>
                    <FormGroup controlId="formBasicName">
                        <FormControl
                        type="text"
                        name="address"
                        placeholder="Enter locale"
                        value={formData.address}
                        onChange={handleInputChange}/>
                    </FormGroup>
                    <Button variant="primary" type="submit" className="w-100">
                        Edit Student
                    </Button>
                </Form>
            </div>
        </>
    )
};

export default UpdateStudent