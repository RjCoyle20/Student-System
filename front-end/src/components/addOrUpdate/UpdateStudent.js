import { useState } from "react"



const UpdateStudent = () => {

    const [formData, setFormData] = useState ({
        name:"",
        address:"",
    })
}
const handleInputChange = (event) => {
    const {name, value} = event.target
    setFormData({
        ...formData,
        [name]:value,
    })
};

export default UpdateStudent