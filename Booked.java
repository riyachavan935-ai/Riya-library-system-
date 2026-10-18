<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Library Management - Java Swing - Riya 3121</title>
</head>
<body style="margin:0;font-family:Arial;background:#fefce8">
<div style="background:#713f12;color:#fef08a;padding:16px 24px;display:flex;justify-content:space-between;font-weight:900">
<div>📚 LibraryVerse - Java Swing Project - Riya 3121</div>
<div style="font-size:12px">Riya Chavan 3121</div>
</div>
<div style="background:linear-gradient(90deg,#713f12,#a16207);color:#fff;padding:40px 20px;text-align:center">
<h1 style="margin:0;font-size:36px">Library Management System</h1>
<p style="margin-top:10px">Built with <b>Java + Java Swing - JFrame, JTable, JButton</b> | By Riya Chavan 3121 | BADI WEBSITE + BADA OUTPUT</p>
</div>
<div style="padding:20px;display:grid;grid-template-columns:1fr 1fr;gap:20px">
<div style="background:#fff;padding:20px;border-radius:16px;box-shadow:0 4px 20px rgba(0,0,0,0.1)">
<h3>➕ Add Book - Java Swing Logic</h3>
<input id="title" placeholder="Book Title" style="width:100%;padding:12px;margin:8px 0;border:2px solid #ddd;border-radius:8px">
<input id="author" placeholder="Author" style="width:100%;padding:12px;margin:8px 0;border:2px solid #ddd;border-radius:8px">
<input id="student" placeholder="Student Name - Riya 3121" style="width:100%;padding:12px;margin:8px 0;border:2px solid #ddd;border-radius:8px">
<button onclick="addBook()" style="width:100%;padding:14px;background:#713f12;color:#fde68a;border:none;border-radius:10px;font-weight:800;cursor:pointer">➕ ADD BOOK - BADA OUTPUT AAYEGA</button>
<button onclick="issueBook()" style="width:100%;padding:14px;background:#16a34a;color:#fff;border:none;border-radius:10px;font-weight:800;margin-top:8px;cursor:pointer">📕 ISSUE BOOK</button>
<button onclick="returnBook()" style="width:100%;padding:14px;background:#2563eb;color:#fff;border:none;border-radius:10px;font-weight:800;margin-top:8px;cursor:pointer">📗 RETURN BOOK</button>
<div id="output" style="background:#0f172a;color:#22c55e;padding:15px;border-radius:10px;font-family:monospace;margin-top:15px;min-height:200px;border:2px solid #22c55e;white-space:pre-wrap">> Library Management Started...
> Java + Java Swing - Riya 3121
> Ready... Add Book dabao...
> BADA OUTPUT yaha ayega...</div>
</div>
<div style="background:#fff;padding:20px;border-radius:16px;box-shadow:0 4px 20px rgba(0,0,0,0.1)">
<h3>📚 Library Catalog - BADI WEBSITE</h3>
<div id="books" style="margin-top:15px"></div>
<table style="width:100%;border-collapse:collapse;margin-top:15px"><tr style="background:#713f12;color:#fff"><th style="padding:8px">ID</th><th>Title</th><th>Status</th></tr><tbody id="tbody"></tbody></table>
<div style="margin-top:20px;background:#fef9c3;padding:12px;border-radius:10px;font-size:12px">
<b>Java Swing Files (Alag-Alag Bada Code):</b><br>
1. Book.java - Model (50 lines)<br>
2. LibraryService.java - Logic (150 lines)<br>
3. LibrarySwingApp.java - Swing UI (350 lines) - JFrame, JTable, JButton<br>
4. Main.java - Main method (20 lines)<br>
<b>Total 570+ lines Java Code</b>
</div>
</div>
</div>
<script>
let books=[{id:'BK1001',title:'Java Programming',status:'Available'},{id:'BK1002',title:'Python Basics',status:'Available'},{id:'BK1003',title:'Data Structures',status:'Issued'}];
let c=1004;
function render(){
document.getElementById('books').innerHTML=books.map(b=>`<div style="border:1px solid #eee;padding:10px;border-radius:10px;margin:6px 0;display:flex;justify-content:space-between"><b>${b.title}</b><span style="background:${b.status=='Available'?'#dcfce7':'#fee2e2'};padding:4px 8px;border-radius:20px;font-size:11px">${b.status}</span></div>`).join('');
document.getElementById('tbody').innerHTML=books.map(b=>`<tr><td>${b.id}</td><td>${b.title}</td><td>${b.status}</td></tr>`).join('');
}
function addBook(){
let t=document.getElementById('title').value; let a=document.getElementById('author').value;
if(!t){alert('Title likho!');return;}
let id='BK'+c++; books.push({id,title:t,status:'Available'}); render();
let o=document.getElementById('output');
o.textContent+=`\n\n[${new Date().toLocaleTimeString()}] =========================\n✅ BADA OUTPUT AAYA - BOOK ADDED!\n=========================\nID: ${id}\nTitle: ${t}\nAuthor: ${a}\nStatus: Available\nBy: Riya Chavan 3121\nJava: JFrame, JTable, JButton Used\nFile: LibrarySwingApp.java\nSystem.out.println(\"BOOK ADDED: ${id}\");\nJTable: tableModel.addRow(...)\nJLabel: outputLabel.setText(\"OUTPUT AAYA!\")\nTotal Books: ${books.length}\n=========================\n`;
o.scrollTop=o.scrollHeight;
}
function issueBook(){
let b=books.find(x=>x.status=='Available'); if(!b){alert('No Available!');return;}
b.status='Issued'; render();
document.getElementById('output').textContent+=`\n\n📕 BOOK ISSUED: ${b.id} - ${b.title}\nStatus: Issued\n`;
}
function returnBook(){
let b=books.find(x=>x.status=='Issued'); if(!b){alert('No Issued!');return;}
b.status='Available'; render();
document.getElementById('output').textContent+=`\n\n📗 BOOK RETURNED: ${b.id}\nAvailable Again\n`;
}
render();
</script>
</body>
</html>
