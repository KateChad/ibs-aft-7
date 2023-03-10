#language: ru

@withdrawal
Функция: Проверка поиска вкладов по параметрам banki.ru

  @regress
  Сценарий: Корректное заполение формы
    * проврка прогрузилось ли верхнее меню
    * перейти в меню "Вклады"
    * проверка прогрузилась ли страничка
    * переход в калькулятор
    * проверка открытия окна калькулятора вкладов
    * ввод суммы вклада"500000"
    * проверка ввод суммы вклада"500000"
    * выбрать в поле "Срок" параметр "2 года"
    * проверка выбора в поле "Срок" параметра "2 года"
    * выбрать в поле "Тип вклада" параметр "Детский"
    * проверка выбора в поле "Тип вклада" параметра "Детский"
    * выбор банков:
      | Ак Барс |
      | РОССИЯ |
      |Сбербанк |
    * проверка выбора банка:
      | Ак Барс |
      | РОССИЯ |
      |Сбербанк |
    * выбор дополнительных параметров:
      |С выплатой процентов|
    * проверка выбора дополнительных параметров:
      |С выплатой процентов|
    * проверка количества вкладов указанных на кнопке "7"
    * клик по кнопке показать результат
    * закрытие модального окна
    * проверка количества вкладов "7"
    * проверка предложений банка "Сбербанк" процентная ставка "6,80" срок "730" доходность "72515"

  @fail
  Сценарий: не корректное заполнение формы