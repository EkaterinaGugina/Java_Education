package Practicum_09_12_22NullData;

import java.util.ArrayList;

import javax.sound.sampled.Port;

public class program {
    public Boolean getPath(int x, int y, ArrayList<Point> path,
                            Hashtable<Point, Boolean> cache){
        Point p = new Point(x, y);
        if (cache.containsKey(p)) { // Мы уже посещали эту ячейку
            return cache.get(p);
        }
        path.add(p);
        if (x == 0 && y == 0) {
            return true;  // Найден путь
        }
        boolean success = false;
        if (x >= 1 && isFree(X - 1, Y)) { //Пытаемся идти вправо
            success = getPath(x - 1, y, path, cache); // Свободно! Можно идти вправо
        }
        if (!success && y >= 1 && isFree(x, y - 1)) { // Пытаемся идти вниз
            success = getPath(x, y - 1, path, cache); // Свободно! Можно идти вниз
        }
        if (!success) {
            path.remove(p); //Неверный путь! Прекратить движение этим маршрутом
        }
        cache.put(p, success); // Вычисляем результат
        return success;
}
// псевдокод

count(g, v)
    if w[v]
        return d[v]
    else
        sum = 0
        w[v] = true
        for c in g[v]
            sum += count(g, c)
        d[v] = sum
        return sum

countPaths(g, s, t)
    d[s] = 1
    w[s] = true
    answer = count(t)
    return answer

    }
