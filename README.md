<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>🏥 Medical History Management System</h1>

<h2>📌 Overview</h2>
<p>
    This project is a lightweight Java application designed to store, manage, and retrieve patient medical records.
    It demonstrates clean object-oriented design, custom exception handling, and service-layer logic — all wrapped in a simple console-based interface.
</p>
<p>
    Whether you're learning Java, exploring service-oriented architecture, or building a foundation for a larger health-care system,
    this project provides a clear and approachable example.
</p>

<h2>✨ Features</h2>

<h3>👤 Patient Management</h3>
<p>Create and store patient profiles with unique identifiers.</p>

<h3>📝 Medical Records Handling</h3>
<p>Add, view, and manage medical records (including allergies) for each patient.</p>

<h3>🧾 Service Layer (<code>MedicalHistoryService</code>)</h3>
<p>A central class that manages all operations involving patients and their records.</p>

<h3>⚠️ Robust Error Handling</h3>
<p>Includes custom exceptions for real-world conditions:</p>
<ul>
    <li><code>PatientNotFoundException</code></li>
    <li><code>RecordNotFoundException</code></li>
    <li><code>RecordExistsException</code></li>
    <li><code>InvalidMedicalRecordException</code></li>
</ul>

<h3>🖥️ Console Application (<code>Main.java</code>)</h3>
<p>A simple driver program showing how to use the system.</p>

<h2>📂 Project Structure</h2>

<pre><code>/src
│── Main.java                      # Application entry point
│── Patient.java                   # Patient model
│── MedicalRecord.java             # Base class for medical records
│── AllergyRecord.java             # Specific type of MedicalRecord
│── MedicalHistoryService.java     # Core logic for managing records
│
└── exceptions/
     ├── PatientNotFoundException.java
     ├── RecordNotFoundException.java
     ├── RecordExistsException.java
     └── InvalidMedicalRecordException.java
</code></pre>

<h2>🚀 How It Works</h2>

<ul>
    <li>Create a <code>MedicalHistoryService</code> instance.</li>
    <li>Add patients using their unique IDs.</li>
    <li>Add medical or allergy records to those patients.</li>
    <li>Retrieve and display records through the service.</li>
    <li>Watch custom exceptions get thrown when something isn’t right.</li>
</ul>

<p>This makes it great for classroom demos, debugging practice, or extending into a larger project.</p>

<h2>🧪 Example Usage (simplified)</h2>

<pre><code>MedicalHistoryService service = new MedicalHistoryService();

Patient john = new Patient("001", "John Doe");
service.addPatient(john);

MedicalRecord allergy = new AllergyRecord("Pollen", "High severity");
service.addMedicalRecord("001", allergy);

System.out.println(service.getMedicalRecords("001"));
</code></pre>

<h2>📈 Future Improvements</h2>
<ul>
    <li>Persistent storage (database or file-based)</li>
    <li>GUI or web front-end</li>
    <li>More record types (conditions, medications, surgeries)</li>
    <li>Unit test suite (JUnit)</li>
</ul>

<h2>🤝 Contributing</h2>
<p>
    Contributions are welcome! Feel free to open issues, suggest improvements, or submit pull requests.
</p>

<h2>📄 License</h2>
<p>
    This project is available under MIT license.
</p>

</body>
</html>
