<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nom = htmlspecialchars($_POST["name"]);
    $email = htmlspecialchars($_POST["email"]);
    $message = htmlspecialchars($_POST["message"]);

    $to = "ton@email.com"; // Remplace par ton adresse email
    $subject = "Nouveau message de contact de $nom";
    $body = "Nom: $nom\nEmail: $email\n\nMessage:\n$message";
    $headers = "From: $email\r\nReply-To: $email\r\n";

    if (mail($to, $subject, $body, $headers)) {
        echo "<p style='color: green;'>Message envoyé avec succès !</p>";
    } else {
        echo "<p style='color: red;'>Erreur lors de l'envoi du message.</p>";
    }
} else {
    echo "<p style='color: red;'>Accès non autorisé.</p>";
}
?>
