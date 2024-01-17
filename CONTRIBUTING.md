# Contributing to interview-ready-java-dsa

Thank you for your interest in contributing to `interview-ready-java-dsa`! We appreciate your efforts to make this project a valuable resource for interview preparation in Java.

## Contribution Workflow

1. **Fork the Repository**: Start by forking the `interview-ready-java-dsa` repository to your own GitHub account.

2. **Clone Your Fork**: Clone your forked repository to your local machine.

```git clone https://github.com/[YourUsername]/interview-ready-java-dsa.git```

3. **Set Up Branches**: Inside your local repository, set up two branches from `main`.
- `feature-local`: For personal development. Commit all your work here.
  ```
  git checkout -b feature-local
  ```
- `feature-collab`: For preparing contributions. Cherry-pick important changes from `feature-local` to this branch.
  ```
  git checkout main
  git checkout -b feature-collab
  ```

4. **Developing and Preparing Contributions**: Work on `feature-local`. Cherry-pick relevant changes to `feature-collab`. Regularly update your fork's `main` by merging `feature-collab`.

```
git checkout main
git merge feature-collab
git push origin main
```

5. **Creating a Pull Request**: Submit a pull request from your fork's `main` to the original `interview-ready-java-dsa` repository for review and integration.

## Coding Style

We adhere to the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html). Use IntelliJ IDEA for code formatting to maintain consistency. Checkstyle can also be integrated for automatic code style verification.

## Reporting Bugs and Suggesting Enhancements

Report bugs or suggest enhancements via GitHub Issues: [Open an issue](https://github.com/tannychaks/interview-ready-java-dsa/issues/new). Include a clear summary, reproduction steps, expected and actual results, and any relevant code or error messages.

## License

Contributions are licensed under the MIT License. By contributing, you agree to abide by its terms.

## Questions or Concerns?

For any questions or concerns about contributing, contact the project maintainers.

Thank you for contributing to `interview-ready-java-dsa`!


