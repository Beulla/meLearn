import { useState } from "react";

export default function AddCourse(){
    const[courseId,setCourseId]=useState('')
    const[courseName,setCourseName]=useState('')
    const[courseDescription,setCourseDescription]=useState('')
    const[courseTitle,setCourseTitle]=useState('')

    const handleCourseIdChange=event=>{
        setCourseId(event.target.value)
    }
    const handleCourseNameChange=event=>{
        setCourseName(event.target.value)
    }
    const handleCourseDescriptionChange=event=>{
        setCourseDescription(event.target.value)
    }
    const handleCourseTitleChange=event=>{
        setCourseTitle(event.target.value)
    }
    const formData=new FormData()
    formData.append("",courseId)
    formData.append("",courseName)
    formData.append("",courseDescription)
    formData.append("",courseTitle)
    const handleSubmit=async(event)=>{
        event.preventDefault()
    }
}