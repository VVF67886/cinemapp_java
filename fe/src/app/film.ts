export interface Film {
    id: number,
    title: string,
    category: string,
    director: string,
    distribution: string,
    producer: string,
    year: number,
    releaseDate: Date,
    plot: string,
    poster: string,
    images: string[],
}
