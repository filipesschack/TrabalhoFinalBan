CREATE TABLE Funcionario (
  idFuncionario SERIAL PRIMARY KEY,
  CPF VARCHAR(11),
  nome VARCHAR(100),
  telefone VARCHAR(20)
);

CREATE TABLE Cliente (
  CPF VARCHAR(11) PRIMARY KEY,
  nome VARCHAR(100),
  endereco VARCHAR(200),
  telefone VARCHAR(20),
  idFuncionario INTEGER REFERENCES Funcionario(idFuncionario),
 datacadastro VARCHAR(20)
);

INSERT INTO Funcionario (CPF, nome, telefone) VALUES
('12345678901', 'João Silva', '987654321'),
('98765432109', 'Maria Souza', '123456789'),
('45678901234', 'Pedro Santos', '654321987');

INSERT INTO Cliente (CPF, nome, endereco, telefone, idFuncionario, datacadastro) VALUES
('11122233344', 'Ana Oliveira', 'Rua A, 123', '111111111', 1, '2023-06-01'),
('22233344455', 'Carlos Pereira', 'Rua B, 456', '222222222', 2, '2023-06-02'),
('33344455566', 'Mariana Rodrigues', 'Rua C, 789', '333333333', 3, '2023-06-03');