% Базовый случай: сумма пустого списка равна 0.
sum_list([], 0).

% Рекурсивный случай: суммируем голову списка с суммой хвоста.
sum_list([Head|Tail], Sum) :-
    sum_list(Tail, TailSum),
    Sum is Head + TailSum.

% Пример использования.
?- sum_list([1, 2, 3, 4, 5], Sum).

% Сайт для проверки кода.
% https://swish.swi-prolog.org/p/eBUBwJHM.pl