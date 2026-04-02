# Guide de Contribution

Pour maintenir un historique propre et une collaboration efficace, merci de respecter les conventions suivantes.

##  Nommage des Commits (Conventional Commits)
Nous utilisons la norme **Conventional Commits**. Chaque message doit suivre ce format :
`<type>(<scope>): <description>`

- **feat**: Nouvelle fonctionnalité
- **fix**: Correction de bug
- **docs**: Documentation uniquement
- **style**: Formatage, ponctuation manquante (pas de modif de code)
- **refactor**: Modification du code qui ne change pas le comportement
- **test**: Ajout ou modification de tests

*Exemple : `feat(auth): ajouter la connexion par Google`*

---

##  Nommage des Branches
Les branches doivent être préfixées par leur catégorie, suivies d'un titre explicite (en minuscules, séparé par des tirets).

| Catégorie | Préfixe | Exemple |
| :--- | :--- | :--- |
| Fonctionnalité | `feature/` | `feature/login-page` |
| Correction | `bugfix/` | `bugfix/header-mobile` |
| Hotfix (Urgent) | `hotfix/` | `hotfix/api-crash` |
| Documentation | `docs/` | `docs/update-readme` |

---

##  Workflow de Travail
1. Créer une branche à partir de `main`.
2. Faire des commits atomiques et bien nommés.
3. Pousser la branche et ouvrir une **Pull Request** (PR).
4. Attendre la validation d'au moins un collègue avant le merge.

