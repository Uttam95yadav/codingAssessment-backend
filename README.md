###### Title:
This api will help the researcher to view the frequency of a given word and any similar words in my lab notebook entry.
it will take the NoteBook text and word as input and give the 
 frequency of word occurrence in notebook and similar words in notebook Entry as output.

# URL

/codingasessment/frequencyandsimilarwords

### Method:

 POST 

### URL Params

{
 "word": "Word",
 "notebookText": "Word Word Word Wor"
}

**Required:**

word=[String]
notebookText=[String]

**Optional:**

No optional argument

**Data Params:**

{
 "word": "Word",
 "notebookText": "Word Word Word Wor"
}

**Success Response:**

    responseCode : 200,
    responseMessage : "Success",
    response : Json object

**Error Response:**


    "timestamp": "2021-05-16T06:09:15.995+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/codingasessment/frequencyandsimilarwords"

**OR

    "timestamp": "2021-05-16T06:09:15.995+00:00",
    "status": 500,
    "message": ""internal server error while getting the Frequency and Similar Words"",
    "path": "/codingasessment/frequencyandsimilarwords"



**Notes:**

**Time Spent:** 

Spent 3 hours to make this api along with the Test case and build the logic to get the similar word and frequency 
and Spent 2 hour to Create the UI will take the input from user and show the result below.(https://github.com/Uttam95yadav/codingAssessment-frontEnd.git)

### Future Improvement;

Can write more test cases.
can improve the error handling.
variable and method name can also improve . 
