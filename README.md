获取公司列表
method: getCompanyList
请求方式: GET
URL: /companies
示例:
GET /companies
Response:
[
{ "id": 1, "name": "Company A" },
{ "id": 2, "name": "Company B" }
]


获取特定公司信息
method: getCompanyById
请求方式: GET
URL: /companies/{id}
示例:
GET /companies/1
Response:
{ "id": 1, "name": "Company A" }

获取特定公司下的员工列表
method: getEmployeesByCompany
请求方式: GET
URL: /companies/{id}/employees
示例:
bash
GET /companies/1/employees
Response:
[
{ "id": 101, "name": "EmployeeOne" },
{ "id": 102, "name": "EmployeeTwo" }
]

分页查询公司列表
method: getCompanyListByPage
请求方式: GET
URL: /companies?page={page}&size={size}
示例:
GET /companies?page=1&size=5
Response:
[
{ "id": 1, "name": "CompanyA" },
{ "id": 2, "name": "CompanyB" },
]

更新公司中的员工信息
method: updateEmployee
请求方式: PUT
URL: /employees/{id}
示例:
PUT /employees/101
Request Body:
{
id:1,
age:18,
"name": "mason",
salary:1900,
gender:"female"
"companyId": 1
}
Response:
{ "id": 101, "name": "Updated Employee Name", "companyId": 1 }

新增公司
method: addCompany
请求方式: POST
URL: /companies
示例:
POST /companies
Request Body:
{
id : 1,
"name": "New Company"
}
Response:
{ "id": 3, "name": "New Company" }

删除公司
method: deleteCompany
请求方式: DELETE
URL: /companies/{id}
示例:
DELETE /companies/1
Response:
{ "message": "Company deleted successfully" }